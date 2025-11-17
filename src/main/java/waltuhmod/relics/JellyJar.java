package waltuhmod.relics;

import com.megacrit.cardcrawl.actions.common.EndTurnAction;
import com.megacrit.cardcrawl.actions.watcher.PressEndTurnButtonAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import waltuhmod.character.Waltuh;

import java.util.Random;

import static waltuhmod.Waltuhmod.makeID;

public class JellyJar extends BaseRelic{

    private static final String NAME = "JellyJar";
    public static final String ID = makeID(NAME);
    private static final RelicTier RARITY = RelicTier.BOSS;
    private static final LandingSound SOUND = LandingSound.HEAVY;
    static Random random = new Random();
    public void onEquip() {
        ++AbstractDungeon.player.energy.energyMaster;
        ++AbstractDungeon.player.energy.energyMaster;
    }

    public void onUnequip() {
        --AbstractDungeon.player.energy.energyMaster;
        --AbstractDungeon.player.energy.energyMaster;
    }

    public void atTurnStartPostDraw(){
        if(random.nextInt(10) == 1){
            addToBot(new PressEndTurnButtonAction());
        }
    }
    public JellyJar(){
        super(ID, NAME, Waltuh.Meta.CARD_COLOR, RARITY, SOUND);
    }
}
