package config.bootstrap;

import javax.ejb.Startup;
import javax.ejb.Singleton;
import javax.annotation.PostConstruct;

@Singleton
@Startup
public class OnStartup {

   @PostConstruct
   public void onStartup() {
       System.out.println("START UP APPLICATION...");
       
       System.out.println("# HIBERNATE: ");
       new config.database.HibernateConfig();
       
       //System.out.println("# CONGIGURATION X: ");
       //OUTRAS CONFIGURAÇÕES INICIAIS AQUI...
       
       System.out.println("START UP APPLICATION FINISHED.");
   }
}