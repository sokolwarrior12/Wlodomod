package waltuhmod.cards;

import com.badlogic.gdx.math.MathUtils;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.SpawnMonsterAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.monsters.exordium.GremlinTsundere;
import waltuhmod.character.Waltuh;
import waltuhmod.util.CardStats;

public class ShieldImp extends BaseCard{
        public static final String ID = makeID("ShieldImp");
        private static final CardStats info = new CardStats(
                Waltuh.Meta.CARD_COLOR,
                CardType.SKILL,
                CardRarity.COMMON,
                CardTarget.SELF,
                1
        );

        private static final int BLOCK = 15;
        private static final int UPG_BLOCK = 10;
        @Override
        public void use(AbstractPlayer p, AbstractMonster m) {

            addToBot(new SpawnMonsterAction(new GremlinTsundere(-700.0F, 0.0F + MathUtils.random(-10.0F, 10.0F)), false));
            addToBot(new GainBlockAction(p, block));
        }


        public ShieldImp(){
            super(ID, info);
            setBlock(BLOCK, UPG_BLOCK);
        }

}
