
import java.util.ArrayList;
/**
 *
 * @author natao
 */
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import java.util.*;

@ManagedBean(name = "calculadoraBean")
@ApplicationScoped
public class megaStat {
    public ArrayList<Float> datos=new ArrayList <Float>();
    public float media;
    public float moda;
    public float desvEst;
    public float varianza;
    

    public megaStat (){}
    
    public ArrayList<Float>  doArraylist(String datos){
       String []lista= datos.split(";");
       ArrayList<Float> valores=new ArrayList<Float>();
       for(String dato:lista){
           valores.add(Float.parseFloat(dato));
       }
       return valores;
    }
    public float calculateMean(String datos){
    ArrayList<Float> valores=doArraylist(datos);    
    float sumatoria=0;
    for (int i=0;i<valores.size();i++){ 
        sumatoria+=valores.get(i);
    }
    media=sumatoria/valores.size();
    return media;
    }
    public float calculateStandardDeviation(String datos){
    ArrayList<Float> valores=doArraylist(datos);
    desvEst=(float)Math.sqrt(calculateVariance(datos));
    return desvEst;
    }
    public float  calculateVariance(String datos){
     ArrayList<Float> valores=doArraylist(datos);
    float sumatoria=0;
    for (int i=0;i<valores.size();i++){ 
       sumatoria+=Math.pow(2,valores.get(i)-getMedia());
    }
    varianza=sumatoria/valores.size();
    return varianza;
    }

   public float calculateMode(String datos) {
        ArrayList<Float> valores=doArraylist(datos);
        int maximoNumRepeticiones= 0;
        moda= 0;
        for(int i=0; i<valores.size(); i++)
        {
         int numRepeticiones=0;
         for(int j=0; j<valores.size(); j++)
         {
            if(valores.get(i)==valores.get(j))
            {
             numRepeticiones=numRepeticiones+1;
            }   
            if(numRepeticiones>maximoNumRepeticiones)
            {
             moda= valores.get(j);
             maximoNumRepeticiones= numRepeticiones;
            }  
         } 
        }  
    return moda;
    }


    public void restart(){
        datos=new ArrayList<Float>();
        media=0;
        moda=0;
        desvEst=0;
        varianza=0;
    }

    public float[] getDato(String datos){
      ArrayList<Float> valores=doArraylist(datos);  
      int n = valores.size();
      float [] vector= new float[n];
      for (int x=0;x<n;x++){ vector[x]=valores.get(x);}
      return vector;
    }
    
    public float getMedia(){
    return media;
    }
    
    public float getModa(){
    return moda;
    }
    
    public float getDesvEst(){
    
    return desvEst;
    }
    
    public float getVarianza(){
   
    return varianza;
    }
    
    public int getCantDato(String datos){
    ArrayList<Float> valores=doArraylist(datos);
    int cantDat = valores.size();
    return cantDat;
    }
    
    public void setDatos(String datos){
    ArrayList<Float> valores=doArraylist(datos);    
    this.datos=valores;
    }  
}
