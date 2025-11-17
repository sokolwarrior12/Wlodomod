package waltuhmod.powers;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainGoldAction;
import com.megacrit.cardcrawl.actions.common.ObtainPotionAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import waltuhmod.CustomTags;
import java.util.ArrayList;
import java.util.Collections;

import static com.badlogic.gdx.graphics.Color.BLUE;
import static com.badlogic.gdx.graphics.Color.GOLD;
import static waltuhmod.Waltuhmod.makeID;

public class BingoPower extends BasePower{
    public static final String POWER_ID = makeID("BingoPower");
    private static final AbstractPower.PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = false;

    public BingoPower(AbstractCreature owner, int amount){
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }
    ArrayList<Object> groupCopy = new ArrayList<>();
    public void onInitialApplication(){

        ArrayList<AbstractCard> shuffledDeck = new ArrayList<>(AbstractDungeon.player.masterDeck.group);
        Collections.shuffle(shuffledDeck);

        int x = amount;
        if (SizeCheck(shuffledDeck)) {
        }
        else {
            for (int i = 0; i < x; i++) {
                AbstractCard card = shuffledDeck.get(i);
                if (!card.tags.contains(CustomTags.BINGO)) {
                    groupCopy.add(shuffledDeck.get(i).cardID);
                } else {
                    x+=1;
                }
            }
        }
        for(int i =0;i< AbstractDungeon.player.hand.size(); i++) {
            if(groupCopy.contains(AbstractDungeon.player.hand.group.get(i).cardID)){
                AbstractDungeon.player.hand.group.get(i).glowColor = GOLD.cpy();
            }
            else{
                AbstractDungeon.player.hand.group.get(i).glowColor = BLUE.cpy();
            }
        }
    }

    private boolean SizeCheck(ArrayList<AbstractCard> shuffledDeck) {
        if(shuffledDeck.size()<amount){
            addToTop(new RemoveSpecificPowerAction(owner, owner, this));
            return true;
        }
        else return false;
    }

    @Override
    public void atStartOfTurnPostDraw() {
        for(int i =0;i< AbstractDungeon.player.hand.size(); i++) {
            if(groupCopy.contains(AbstractDungeon.player.hand.group.get(i).cardID)){
                AbstractDungeon.player.hand.group.get(i).glowColor = GOLD.cpy();
            }
            else{
                AbstractDungeon.player.hand.group.get(i).glowColor = BLUE.cpy();
            }
        }
    }

    public void onUseCard(AbstractCard card, UseCardAction action) {
        for(int i =0;i< AbstractDungeon.player.hand.size(); i++) {
            if(groupCopy.contains(AbstractDungeon.player.hand.group.get(i).cardID)){
                AbstractDungeon.player.hand.group.get(i).glowColor = GOLD.cpy();
            }
            else{
                AbstractDungeon.player.hand.group.get(i).glowColor = BLUE.cpy();
            }
        }
        if(groupCopy.contains(card.cardID)){
            groupCopy.remove(card.cardID);
            if (groupCopy.isEmpty()) {
                if (amount == 5) {
                    addToTop(new GainGoldAction(150));
                    addToTop(new ObtainPotionAction(AbstractDungeon.returnRandomPotion(true)));

                }
                else if(amount == 3){
                    addToTop(new GainGoldAction(200));
                    addToTop(new ObtainPotionAction(AbstractDungeon.returnRandomPotion(true)));
                }
                addToTop(new ApplyPowerAction(owner, owner, new BingoScoredPower(owner, 1)));
                addToTop(new RemoveSpecificPowerAction(owner, owner, this));

            }
        }
    }
}
