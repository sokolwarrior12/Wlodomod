package waltuhmod.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.WeakPower;
import waltuhmod.character.Waltuh;
import waltuhmod.util.CardStats;

public class DeskSlam extends BaseCard{
    public static final String ID = makeID("DeskSlam");
    private static final CardStats info = new CardStats(
            Waltuh.Meta.CARD_COLOR,
            CardType.SKILL,
            CardRarity.COMMON,
            CardTarget.ALL_ENEMY,
            0
    );
    private static final int MAGIC_NUMBER = 5;
    private static final int UPG_MAGICNUMBER = 5;


    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        for(AbstractMonster mo : AbstractDungeon.getCurrRoom().monsters.monsters) {
            this.addToBot(new ApplyPowerAction(mo, p, new WeakPower(mo, this.magicNumber, false), this.magicNumber, true, AbstractGameAction.AttackEffect.NONE));
        }
    }
    public DeskSlam(){
        super(ID, info);
        setMagic(MAGIC_NUMBER, UPG_MAGICNUMBER);
        setExhaust(true);
    }
}
