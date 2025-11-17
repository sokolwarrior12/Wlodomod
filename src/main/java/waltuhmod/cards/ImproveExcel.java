package waltuhmod.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import waltuhmod.character.Waltuh;
import waltuhmod.powers.ImproveExcelPower;
import waltuhmod.util.CardStats;

public class ImproveExcel extends BaseCard{
    public static final String ID= makeID("ImproveExcel");
    private static final CardStats info = new CardStats(
            Waltuh.Meta.CARD_COLOR,CardType.POWER, CardRarity.UNCOMMON, CardTarget.SELF, 1
    );

    @Override
    public void use(AbstractPlayer p, AbstractMonster m)
    {
        addToBot( new ApplyPowerAction(p, p, new ImproveExcelPower(p, 1)));
    }
    public void onChoseThisOption() {
        AbstractPlayer p = AbstractDungeon.player;
        addToBot( new ApplyPowerAction(p, p, new ImproveExcelPower(p, 1)));
    }

    public ImproveExcel(){
        super(ID, info);
    }
}
