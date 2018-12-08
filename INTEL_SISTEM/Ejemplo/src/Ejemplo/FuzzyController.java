package Ejemplo;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.rule.Rule;

public class FuzzyController {
    private FIS fis;
    
     public FuzzyController() {
    
             fis = FIS.load(getClass().getResourceAsStream("tipper.fcl"), true);

             if (fis == null) {
                    System.err.println("Can't load file: 'tipper.fcl'");
                    return;
             }

        //mostrar los gráficos de conjuntos de las variables difusas
        fis.chart();        
     }   
     void execute(){
        fis.setVariable("service", 3);
        fis.setVariable("food", 7);

        // Evaluate
        fis.evaluate();
        // Show output variable
        System.out.println("tip value:" + fis.getVariable("tip").getValue()); 

        // Show each rule (and degree of support)
        for (Rule r : fis.getFunctionBlock("tipper").getFuzzyRuleBlock("No1").getRules())
            System.out.println(r);

        // Show output variable's chart 
        fis.getVariable("tip").chartDefuzzifier(true);      
         
     }
}
