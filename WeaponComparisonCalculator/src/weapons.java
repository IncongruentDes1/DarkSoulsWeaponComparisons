
public class weapons {
			
	// - Weapon Name:Type:Attack Type:Physical Damage:Magic Damage :Fire Damage:Lightning Damage:cbonus (special action?):Strength Requirement:Dex Requirement:Intelligence Requirement:Faith Requirement:Durability
	// - Values
	
	String weaponName;
	String type;
	String attackType;
	
	Integer physDamage;
	Integer magDamage;
	Integer fireDamage;
	Integer lightningDamage;
	Integer cBonus;
	
	Integer totDamage;
	
	Integer strengthReq;
	Integer dexReq;
	Integer intReq;
	Integer faithReq;
	
	Integer durability;

	
	
	
	public weapons(String Name, String Type, String AttackType, Integer  PhysDamage,  Integer  MagDamage,  Integer  FireDamage, Integer LightningDamage,  Integer CBonus, Integer StrengthReq, Integer DexReq,  Integer IntReq, Integer FaithReq, Integer Durability) {
              weaponName = Name;
              type = Type;
              attackType = AttackType;
              
              physDamage = PhysDamage;
              magDamage = MagDamage;
              fireDamage = FireDamage;
              lightningDamage = LightningDamage;
              cBonus = CBonus;
              
              totDamage = physDamage + magDamage + fireDamage + lightningDamage;
              
              strengthReq = StrengthReq;
              dexReq = DexReq;
              intReq = IntReq;
              faithReq = FaithReq;
              
              durability = Durability;

			}
	
	public String toString() {
		String str = " ";
		
		str += weaponName  + ": " + totDamage;
		return str;
	}
	
	public  String weaponComparisonStats() {
		String str = "<html> ";
		
		str += "Weapon Name: " + weaponName + "<br><br>";
		
		str += "Type: "+ type + "<br>";
		str += "Attack Type: " + attackType + "<br>";
	    str += "Durability: " + durability  + "<br>";
		str += "<br>";
		
		str += "Damage Stats:" + "<br><br>";
		str += "Physical Damage: " + physDamage  + "<br>";
		str += "Magical Damage: " + magDamage + "<br>";
		str += "Fire Damage: " + fireDamage  + "<br>";
		str += "Lightning Damage: " + lightningDamage  + "<br>";
	    str += "Total Damage: " + totDamage  + "<br>";
	    
	    str += "Stat Requirements: <br><br>";
	    str += "Strength Requirement: " + strengthReq  + "<br>";
	    str += "Dexterity Requirements" + dexReq  + "<br>";
	    str += "Intelligence Requirement" + intReq  + "<br>";

	    
	    
		
				
		
		
		str += "</html>";
		
		
		
		return str;
	}
	
	
}
