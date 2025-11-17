package waltuhmod.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.PoisonPower;
import waltuhmod.character.Waltuh;
import waltuhmod.util.CardStats;

public class RadioactiveBoars extends  BaseCard{
    public static final String ID = makeID("RadioactiveBoars");
    private static final CardStats info =new CardStats(
            Waltuh.Meta.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.UNCOMMON,
            CardTarget.ALL_ENEMY,
            1
    );
    private static final int baseMagicNumber = 4;
    private static final int MagicNumber = 2;
    private static final int DAMAGE = 8;
    private static final int UPG_DAMAGE = 4;
    @Override
    public void use(AbstractPlayer p, AbstractMonster m){
        addToBot(new DamageAllEnemiesAction(p, damage, DamageInfo.DamageType.NORMAL, AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        if (!AbstractDungeon.getMonsters().areMonstersBasicallyDead()) {
            this.flash();

            for(AbstractMonster monster : AbstractDungeon.getMonsters().monsters) {
                if (!monster.isDead && !monster.isDying) {
                    this.addToBot(new ApplyPowerAction(monster, p, new PoisonPower(monster, p, this.magicNumber), this.magicNumber));
                }
            }
        }
    }
    public RadioactiveBoars(){
        super(ID, info);
        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(baseMagicNumber, MagicNumber);
    }
}
