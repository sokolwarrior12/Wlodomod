package waltuhmod.cards;

import com.badlogic.gdx.math.MathUtils;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.SpawnMonsterAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.monsters.exordium.GremlinThief;
import waltuhmod.character.Waltuh;
import waltuhmod.util.CardStats;


public class SneakyImp extends BaseCard{
    public static final String ID = makeID("SneakyImp");
    private static final CardStats info = new CardStats(
            Waltuh.Meta.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.COMMON,
            CardTarget.ENEMY,
            2
    );

    private static final int DAMAGE = 20;
    private static final int UPG_DAMAGE = 20;
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        addToBot(new SpawnMonsterAction(new GremlinThief(-700.0F, 0.0F + MathUtils.random(-10.0F, 10.0F)), false));
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL)));
    }


    public SneakyImp(){
        super(ID, info);
        setDamage(DAMAGE, UPG_DAMAGE);
    }

}
