package waltuhmod.cards;

import com.badlogic.gdx.math.MathUtils;
import com.megacrit.cardcrawl.actions.common.GainGoldAction;
import com.megacrit.cardcrawl.actions.common.ObtainPotionAction;
import com.megacrit.cardcrawl.actions.common.SpawnMonsterAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.monsters.exordium.GremlinNob;
import waltuhmod.character.Waltuh;
import waltuhmod.util.CardStats;

public class NobImp extends BaseCard{

        public static final String ID = makeID("NobImp");
        private static final CardStats info = new CardStats(
                Waltuh.Meta.CARD_COLOR,
                CardType.SKILL,
                CardRarity.RARE,
                CardTarget.SELF,
                2
        );
        private static final int MAGICNUMBERBASE = 100;
        private static final int UPG_MAGICNUMBER = 50;
        @Override
        public void use(AbstractPlayer p, AbstractMonster m) {

            addToBot(new SpawnMonsterAction(new GremlinNob(-700.0F, 0.0F + MathUtils.random(-10.0F, 10.0F)), false));
            addToBot(new GainGoldAction(magicNumber));
            addToBot(new ObtainPotionAction(AbstractDungeon.returnRandomPotion(true)));

        }

        public NobImp(){
            super(ID, info);
            setMagic(MAGICNUMBERBASE, UPG_MAGICNUMBER);
            setExhaust(true);
            setCostUpgrade(1);

        }

    }
