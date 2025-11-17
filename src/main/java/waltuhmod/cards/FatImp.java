package waltuhmod.cards;

import com.badlogic.gdx.math.MathUtils;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.SpawnMonsterAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.monsters.exordium.GremlinFat;
import com.megacrit.cardcrawl.powers.WeakPower;
import waltuhmod.character.Waltuh;
import waltuhmod.util.CardStats;

public class FatImp extends BaseCard{

        public static final String ID = makeID("FatImp");
        private static final CardStats info = new CardStats(
                Waltuh.Meta.CARD_COLOR,
                CardType.ATTACK,
                CardRarity.UNCOMMON,
                CardTarget.ENEMY,
                1
        );

        private static final int DAMAGE = 10;
        private static final int UPG_DAMAGE = 10;
        private static final int MAGIC = 15;
        private static final int UPG_MAGIC = 5;
        @Override
        public void use(AbstractPlayer p, AbstractMonster m) {

            addToBot(new SpawnMonsterAction(new GremlinFat(-700.0F, 0.0F + MathUtils.random(-10.0F, 10.0F)), false));
            addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL)));
            addToBot(new ApplyPowerAction(m, p, new WeakPower(m, magicNumber, false)));
        }


        public FatImp(){
            super(ID, info);
            setDamage(DAMAGE, UPG_DAMAGE);
            setMagic(MAGIC, UPG_MAGIC);
        }

    }


