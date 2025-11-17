package waltuhmod.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import waltuhmod.character.Waltuh;
import waltuhmod.powers.ExcelOSPower;
import waltuhmod.util.CardStats;

public class ExcelOS extends BaseCard{
    public static final String ID = makeID("ExcelOS");
    private static final CardStats info = new CardStats(
            Waltuh.Meta.CARD_COLOR,
            CardType.POWER,
            CardRarity.SPECIAL,
            CardTarget.SELF,
            2
    );
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToTop(new ApplyPowerAction(p, p, new ExcelOSPower(p, 1)));
    }
    public ExcelOS(){
        super(ID, info);
    }
}
