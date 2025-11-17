package waltuhmod.cards;

import com.megacrit.cardcrawl.actions.watcher.ChooseOneAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import waltuhmod.character.Waltuh;
import waltuhmod.util.CardStats;

import java.util.ArrayList;

public class EnchanceExcel extends BaseCard {
    public static final String ID = makeID("EnchanceExcel");
    private static final CardStats info = new CardStats(
            Waltuh.Meta.CARD_COLOR, CardType.SKILL, CardRarity.RARE, CardTarget.SELF, 1
    );


    public void use(AbstractPlayer p, AbstractMonster m) {
        ArrayList<AbstractCard> stanceChoices = new ArrayList();
        stanceChoices.add(new ImproveExcel());
        stanceChoices.add(new ExtendExcel());
        if (this.upgraded) {
            for(AbstractCard c : stanceChoices) {
                c.upgrade();
            }
        }
        this.addToBot(new ChooseOneAction(stanceChoices));
    }

    public EnchanceExcel() {
        super(ID, info);
    }
}