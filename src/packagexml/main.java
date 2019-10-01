package packagexml;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import packagexml.beans.Gear;
import packagexml.services.SellItem;
public class main {
    public static void main(String[] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Gear gearBeans = context.getBean("gear",Gear.class);

        System.out.print(gearBeans.showPriceCheck());



    }
}
