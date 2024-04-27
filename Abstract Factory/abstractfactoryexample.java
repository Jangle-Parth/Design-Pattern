interface Tank{
    void gettype();
}

class VerticalAcidStorage implements Tank{
    public void gettype(){
        System.out.println("Vertical Acid Storage Tank");
    }
}

class HorizontalAcidStorage implements Tank{
    public void gettype(){
        System.out.println("Horizontal Acid Storage tank");
    }
}

class HorizontalMilkStorage implements Tank{
    public void gettype(){
        System.out.println("Horizontal Milk Storage Tank");
    }
}

class VerticalMilkStorage implements Tank{
    public void gettype(){
        System.out.println("Vertical Milk Storage Tank");
    }
}

abstract class Abstractfactory{
    abstract Tank getTank(String tanktype);
}

class AcidStorageTank extends Abstractfactory{
    public Tank getTank(String tanktype){
        if(tanktype.equalsIgnoreCase("horizontal")){
            return new HorizontalAcidStorage();
        }
        else if(tanktype.equalsIgnoreCase("vertical")){
            return new VerticalAcidStorage();
        }
        return null;
    }

}

class MilkStorageTank extends Abstractfactory{
    public Tank getTank(String tanktype){
        if(tanktype.equalsIgnoreCase("horizontal")){
            return new HorizontalMilkStorage();
        }
        else if(tanktype.equalsIgnoreCase("vertical")){
            return new VerticalMilkStorage();
        }
        return null;
}
}

class FactoryProducer{
    public static Abstractfactory getFactory(String name){
        if(name.equalsIgnoreCase("Acid Storage")){
            return new AcidStorageTank();
        }
        else if(name.equalsIgnoreCase("Milk Storage")){
            return new MilkStorageTank();
        }
        else{
            return null;
        }
    }
}

public class abstractfactoryexample{
    public static void main(String[] args) {
        // Horizontal = True
        Abstractfactory tankfactory = FactoryProducer.getFactory("acid storage");
        Tank VBL = tankfactory.getTank("vertical");
        VBL.gettype();
        Tank Amul = tankfactory.getTank("horizontal");
        Amul.gettype();
        
        // Vertical = True
        Abstractfactory ATPL = FactoryProducer.getFactory("milk storage");
        Tank CocaCola = ATPL.getTank("vertical");
        Tank Nestle = ATPL.getTank("horizontal");
        CocaCola.gettype();
        Nestle.gettype();
} }



