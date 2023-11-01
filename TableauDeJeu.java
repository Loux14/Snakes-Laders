
public class TableauDeJeu {
	
    private Tuile[] Tableau = new Tuile[100];         //Le tableau de jeu

    TableauDeJeu()
    {
    	for(int i=0;i<100;i++)
    		Tableau[i]=new Tuile(i);
    	
    	Tableau[98].makeSpecialType(53);
    	Tableau[69].makeSpecialType(54);
    	Tableau[51].makeSpecialType(41);
    	Tableau[24].makeSpecialType(1);    	
    	Tableau[94].makeSpecialType(71);   

    	Tableau[5].makeSpecialType(24);
    	Tableau[10].makeSpecialType(39);
    	Tableau[59].makeSpecialType(84);
    	Tableau[45].makeSpecialType(89);    	
    	Tableau[16].makeSpecialType(68);  
    
    }

   protected Tuile[] getTableau() {
    	return Tableau;
    	
    }

}


    