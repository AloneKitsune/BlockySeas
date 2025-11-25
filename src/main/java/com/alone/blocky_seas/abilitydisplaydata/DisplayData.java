package com.alone.blocky_seas.abilitydisplaydata;

import com.alone.blocky_seas.network.BlockySeasModVariables;
import com.alone.blocky_seas.procedures.HelperMethods;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class DisplayData
{
    // bulk texture list

    private static final ArrayList<String> blank_abilityTextures = new ArrayList<>();
    //fruit

    private static final ArrayList<String> bomb_abilityTextures = new ArrayList<>();
    private static final ArrayList<String> whirlwind_abilityTextures = new ArrayList<>();
    private static final ArrayList<String> sculk_abilityTextures = new ArrayList<>();
    private static final ArrayList<String> game_abilityTextures = new ArrayList<>();

    //sword
    private static final ArrayList<String> cutlass_abilityTextures = new ArrayList<>();
    private static final ArrayList<String> dagger_abilityTextures = new ArrayList<>();

    static
    {
        blank_abilityTextures.add("blocky_seas:textures/screens/noabilityicon.png");
        //fruits
        bomb_abilityTextures.add("blocky_seas:textures/screens/bombability_1.png");
        bomb_abilityTextures.add("blocky_seas:textures/screens/bombability_2.png");
        bomb_abilityTextures.add("blocky_seas:textures/screens/bombability_3.png");

        sculk_abilityTextures.add("blocky_seas:textures/screens/sculkability_1.png");
        sculk_abilityTextures.add("blocky_seas:textures/screens/noabilityicon.png");
        sculk_abilityTextures.add("blocky_seas:textures/screens/noabilityicon.png");
        sculk_abilityTextures.add("blocky_seas:textures/screens/noabilityicon.png");
        sculk_abilityTextures.add("blocky_seas:textures/screens/noabilityicon.png");

        whirlwind_abilityTextures.add("blocky_seas:textures/screens/whirlwindability_1.png");
        whirlwind_abilityTextures.add("blocky_seas:textures/screens/noabilityicon.png");
        whirlwind_abilityTextures.add("blocky_seas:textures/screens/noabilityicon.png");
        whirlwind_abilityTextures.add("blocky_seas:textures/screens/noabilityicon.png");
        whirlwind_abilityTextures.add("blocky_seas:textures/screens/noabilityicon.png");

        game_abilityTextures.add("blocky_seas:textures/screens/gameability_1.png");
        game_abilityTextures.add("blocky_seas:textures/screens/gameability_2.png");
        game_abilityTextures.add("blocky_seas:textures/screens/noabilityicon.png");
        game_abilityTextures.add("blocky_seas:textures/screens/noabilityicon.png");
        game_abilityTextures.add("blocky_seas:textures/screens/noabilityicon.png");
        //
        //swords
        cutlass_abilityTextures.add("blocky_seas:textures/screens/noabilityicon.png");
        cutlass_abilityTextures.add("blocky_seas:textures/screens/noabilityicon.png");
        cutlass_abilityTextures.add("blocky_seas:textures/screens/noabilityicon.png");

        dagger_abilityTextures.add("blocky_seas:textures/screens/noabilityicon.png");
        dagger_abilityTextures.add("blocky_seas:textures/screens/noabilityicon.png");
        //
    }

    public static String getFruitAbilityIcon(Entity entity, int slot)
    {
        String[] result = new String[1];
        entity.getCapability(BlockySeasModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(cap -> {
            result[0] = cap.fruitAbilityList.get(slot);
        });
        return "blocky_seas:textures/screens/" + result[0] + ".png";
    }

    public static void setPlayerFruitAbility(Entity entity, String image, int slot)
    {
        if (!(entity instanceof Player player))
            return;

        entity.getCapability(BlockySeasModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(cap -> {
            int index = slot - 1;
            cap.fruitAbilityList.set(index,image);

            cap.syncPlayerVariables(player);
        });
    }

    public static String getFruitAbilityName(Entity entity, int slot)
    {
        // Slot must be 1–5
        if (slot < 1 || slot > 5) {
            return "";
        }

        AtomicReference<String> result = new AtomicReference<>("");

        entity.getCapability(BlockySeasModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(cap -> {

            // Safety check in case the list is not initialized or too short
            if (cap.fruitAbilityList != null && cap.fruitAbilityList.size() >= slot) {
                String ability = cap.fruitAbilityList.get(slot - 1);

                if (ability != null && !ability.isEmpty()) {
                    result.set(ability);
                }
            }
        });

        return result.get();
    }


    // dont use below
    public static ArrayList<String> getAbilityAssets(Entity entity)
    {
        // will return the users current abilities. (If the user has a fruit and is holding a weapon return weapon's abilities)

        ArrayList<String> result = switch (HelperMethods.getWeapon(entity).toLowerCase()) {
            case "cutlass" -> cutlass_abilityTextures;
            case "dagger"  -> dagger_abilityTextures;
            default        -> null;
        };
        if (result != null) {
            return result;
        }

        // returns fruit or blank if none
        return switch (HelperMethods.getFruit(entity)) {
            case "bomb" -> bomb_abilityTextures;
            case "whirlwind" -> whirlwind_abilityTextures;
            case "sculk" -> sculk_abilityTextures;
            case "game" -> game_abilityTextures;
            default -> blank_abilityTextures;
        };


    }

    public static String getAbilityTexture(ArrayList<String> arr, int index) {
        return arr.get(index);
    }

}
