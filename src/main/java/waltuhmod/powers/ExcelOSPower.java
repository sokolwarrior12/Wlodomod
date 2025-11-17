package waltuhmod.powers;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageRandomEnemyAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

import static waltuhmod.Waltuhmod.makeID;

public class ExcelOSPower extends BasePower{
    public static final String POWER_ID = makeID("ExcelOSPower");
    public static final String TEST_ID = makeID("ExcelOS");
    public static final String TEST_ID2 = makeID("ImproveExcelPower");
    private static final AbstractPower.PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = true;

    public ExcelOSPower(AbstractCreature owner, int amount){
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }
    public ArrayList<ArrayList<Object>> Excel = new ArrayList<>();
    public java.util.Random randomx = new Random();
    public int rngx = 0;
    public int rngy = 0;
    public java.util.Random randomy = new Random();

    public void onInitialApplication() {
        for (int i = 0; i < 2; i++) {
            ArrayList<Object> TEMP = new ArrayList<>();
            TEMP.add("D");
            TEMP.add(1);
            TEMP.add("+");
            TEMP.add(1);
            Excel.add(TEMP);
        }
        rngx = randomx.nextInt(Excel.get(0).size() - 1) + 1;
        rngy = randomy.nextInt(Excel.size());
        System.out.println(rngx);
        System.out.println(rngy);
    }

    @Override
    public void atEndOfTurn(boolean isPlayer) {
        super.atEndOfTurn(isPlayer);

        int pom1 = -1;
        int pom2 = 0;
        for (int i = 0; i < Excel.size(); i++) {
            int wyn = 0;
            for (int j = 0; j < Excel.get(i).size(); j++) {

                if (j == 0) {
                    switch (Excel.get(i).get(j).toString()) {
                        case "D":
                            pom1 = 0;
                            break;
                        case "B":
                            pom1 = 1;
                            break;
                    }
                } else {
                    if (j % 2 != 0) {

                        switch (pom2) {
                            case 0:
                                wyn += (Integer) Excel.get(i).get(j);
                                break;
                            case 1:
                                wyn *= (Integer) Excel.get(i).get(j);
                                break;
                        }
                    } else {
                        switch (Excel.get(i).get(j).toString()) {
                            case "+":
                                pom2 = 0;
                                break;
                            case "*":
                                pom2 = 1;
                                break;
                        }
                    }

                }
            }
                switch (pom1) {
                    case 0:
                        addToBot(new DamageRandomEnemyAction(new DamageInfo(owner, wyn, DamageInfo.DamageType.THORNS), AbstractGameAction.AttackEffect.NONE));
                        break;
                    case 1:
                        addToBot(new GainBlockAction(owner, wyn));
                }

        }
            rngx = randomx.nextInt(Excel.get(0).size() - 1) + 1;
            rngy = randomy.nextInt(Excel.size());
        System.out.println(rngx);
        System.out.println(rngy);
    }

    @Override
    public void onAfterCardPlayed(AbstractCard usedCard) {
        super.onAfterCardPlayed(usedCard);
        if(Objects.equals(usedCard.cardID, TEST_ID)){
            if( rngx%2!=0) {

                Excel.get(rngy).set(rngx, (((Integer) Excel.get(rngy).get(rngx) )+1) );

            }
            else{
                Excel.get(rngy).set(rngx, (String) "*" );
            }
        }
    }

    @Override
    public void onApplyPower(AbstractPower power, AbstractCreature target, AbstractCreature source) {
        super.onApplyPower(power, target, source);
        if(Objects.equals(power.ID, TEST_ID2)){
            if( rngx%2!=0) {

                Excel.get(rngy).set(rngx, (((Integer) Excel.get(rngy).get(rngx) )+1) );

            }
            else{
                Excel.get(rngy).set(rngx, (String) "*" );
            }
        }
    }
}
