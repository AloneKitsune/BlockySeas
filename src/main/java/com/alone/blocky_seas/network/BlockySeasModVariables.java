package com.alone.blocky_seas.network;

import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import com.alone.blocky_seas.BlockySeas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockySeasModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		BlockySeas.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			clone.fruit = original.fruit;
			clone.ability1 = original.ability1;
			clone.ability2 = original.ability2;
			clone.ability3 = original.ability3;
			clone.ability4 = original.ability4;
			clone.ability5 = original.ability5;
			clone.haki = original.haki;
			clone.usingMove = original.usingMove;
			clone.fruitAbilityList = new ArrayList<>(original.fruitAbilityList);

			if (!event.isWasDeath()) {
			}
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(ResourceLocation.fromNamespaceAndPath("blockyseas", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public String fruit = "";
		public double ability1 = 0;
		public double ability2 = 0;
		public double ability3 = 0;
		public double ability4 = 0;
		public double ability5 = 0;
		public boolean haki = false;
		public boolean usingMove = false;

		public List<String> fruitAbilityList = new ArrayList<String>();
		public List<String> swordAbilityList = new ArrayList<String>();


		public PlayerVariables()
		{
			for (int i = 0; i < 5; i++) {
				fruitAbilityList.add("noabilityicon");
				swordAbilityList.add("noabilityicon");
			}
		}

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				BlockySeas.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putString("fruit", fruit);
			nbt.putDouble("ability1", ability1);
			nbt.putDouble("ability2", ability2);
			nbt.putDouble("ability3", ability3);
			nbt.putDouble("ability4", ability4);
			nbt.putDouble("ability5", ability5);
			nbt.putBoolean("haki", haki);
			nbt.putBoolean("usingMove", usingMove);

			ListTag listTag = new ListTag();
			for (String s : fruitAbilityList) {
				listTag.add(StringTag.valueOf(s));
			}
			nbt.put("fruitAbilityList", listTag);

			listTag = new ListTag();
			for (String s : swordAbilityList) {
				listTag.add(StringTag.valueOf(s));
			}
			nbt.put("swordAbilityList", listTag);

			return nbt;
		}

		public void readNBT(Tag tag) {
			CompoundTag nbt = (CompoundTag) tag;
			fruit = nbt.getString("fruit");
			ability1 = nbt.getDouble("ability1");
			ability2 = nbt.getDouble("ability2");
			ability3 = nbt.getDouble("ability3");
			ability4 = nbt.getDouble("ability4");
			ability5 = nbt.getDouble("ability5");
			haki = nbt.getBoolean("haki");
			usingMove = nbt.getBoolean("usingMove");

			fruitAbilityList.clear();
			swordAbilityList.clear();

			ListTag listTag = nbt.getList("fruitAbilityList", Tag.TAG_STRING);
			for (Tag t : listTag) {
				fruitAbilityList.add(t.getAsString());
			}
			listTag = nbt.getList("swordAbilityList", Tag.TAG_STRING);
			for (Tag t : listTag) {
				swordAbilityList.add(t.getAsString());
			}
		}
	}

	public static class PlayerVariablesSyncMessage {
		private final PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.fruit = message.data.fruit;
					variables.ability1 = message.data.ability1;
					variables.ability2 = message.data.ability2;
					variables.ability3 = message.data.ability3;
					variables.ability4 = message.data.ability4;
					variables.ability5 = message.data.ability5;
					variables.haki = message.data.haki;
					variables.usingMove = message.data.usingMove;

					variables.fruitAbilityList = new ArrayList<>(message.data.fruitAbilityList);
					variables.swordAbilityList = new ArrayList<>(message.data.swordAbilityList);

				}
			});
			context.setPacketHandled(true);
		}
	}
}