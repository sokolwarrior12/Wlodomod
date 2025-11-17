package waltuhmod.cards;

import com.megacrit.cardcrawl.actions.unique.WhirlwindAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import waltuhmod.character.Waltuh;
import waltuhmod.util.CardStats;

public class Avalanche extends BaseCard{
    public static final String ID = makeID("Avalanche");
    private static final CardStats info = new CardStats(
            Waltuh.Meta.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.SPECIAL,
            CardTarget.ALL_ENEMY,
            -1
    );
    private static final int DAMAGE = 10;
    private static final int UPG_DAMAGE = 5;
    @Override
    public void use(AbstractPlayer p, AbstractMonster m){
        addToBot(new WhirlwindAction(p, this.multiDamage, this.damageType, false, this.energyOnUse));
    }

    public Avalanche(){
        super(ID, info);
        setDamage(DAMAGE, UPG_DAMAGE);
        setExhaust(true);
    }
}
