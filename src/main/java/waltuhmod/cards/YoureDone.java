package waltuhmod.cards;

import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import waltuhmod.character.Waltuh;
import waltuhmod.util.CardStats;

public class YoureDone extends BaseCard{
    public static final String ID = makeID("YoureDone");
    public static final CardStats info = new CardStats(
            Waltuh.Meta.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.RARE,
            CardTarget.ENEMY,
            3
    );
    private static final int DAMAGE = 1;
    private static final int baseMAGICNUMBER = 100;
    private static final int MAGICNUMBER = 100;
    public void use(AbstractPlayer p, AbstractMonster m){
        for(int i=0;i<magicNumber;i++){
            addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL)));
        }
    }
    public YoureDone(){
        super(ID, info);
        setMagic(baseMAGICNUMBER, MAGICNUMBER);
        setDamage(DAMAGE);
        setExhaust(true);
    }
}
