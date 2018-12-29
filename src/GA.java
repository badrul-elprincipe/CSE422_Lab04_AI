/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 *
 * @author user
 */
public class GA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String []s;
        int inte[];
        int fit[];
        double fitr[];
        double cfit[];
        Random r=new Random();
        int foo = Integer.parseInt("1101", 2);
        System.out.println("Foo: "+foo);
        //The size of the chromosome population N is 6.
        //The crossover probability pc=0.7
        //The mutation probability=0.001
        //The fitness function=f(x)=15x-x2
        s=new String[6];
        inte=new int[s.length];
        fit=new int[s.length];
        fitr=new double[s.length];
        cfit=new double[s.length];
        for(int i=0;i<s.length;i++){//creating random cromosom and decode integer
            s[i]=r.nextInt(2)+""+r.nextInt(2)+""+r.nextInt(2)+""+r.nextInt(2);
            inte[i]=Integer.parseInt(s[i], 2);
            //System.out.println(s[i]);
        } 
        double sump=0;
        for(int a=0;a<500;a++){
            if(a!=0){
                for(int i=0;i<s.length;i++){//decode integer
                   inte[i]=Integer.parseInt(s[i], 2);

                }
            }
            double sum=0;
            for (int i = 0; i <s.length; i++) {// determine fitness and sum them
                fit[i]=15*inte[i]-inte[i]*inte[i];
                sum=sum+fit[i];

            }
            System.out.println(sum);
            if(sump>sum){
                break;
            }

            sump=sum;
            for (int i = 0; i < s.length; i++) {//determining fitness ratio and cumulative ratio
                fitr[i]=(fit[i]/sum)*100;
                if(i==0){
                   cfit[i]=fitr[i] ;
                }
                else{
                    cfit[i]=cfit[i-1]+fitr[i];
                }


            }


            //crossover start
            String s1[]=new String[s.length];
            //taking parent
            int u=0;//for s1 traverse
            for(int h=0;h<3;h++){
            int p1=-1;
            int p2=-1;
            int rp=r.nextInt(100);       
            for (int i = 0; i < 6; i++) {
                if(rp<cfit[i]){
                   p1=i;
                   break;
                }
            }
            int rp1=r.nextInt(100);       
            for (int i = 0; i < 6; i++) {
                if(rp1<cfit[i]){
                   p2=i;
                   break;
                }
            }


            char []p11=s[p1].toCharArray();
            char []p22=s[p2].toCharArray();
            //starting mating
            for(int i=r.nextInt(4);i<4;i++){
                char l=p11[i];
                p11[i]=p22[i];
                p22[i]=l;

            }
            String ss="";
            String sss="";
             for(int i=0;i<p11.length;i++){
                 ss=ss+p11[i];
                 sss=sss+p22[i];
             }
              s1[u]=ss;
              u++;
              s1[u]=sss;
              u++;
            }
          

            //mutation
            for (int i = 0; i < s1.length; i++) {
                if(r.nextInt(3)/1000==.001){
                    char []mm=s1[i].toCharArray();
                    int o=r.nextInt(4);
                    if(Integer.parseInt(mm[o]+"")==1){
                        mm[o]=0;
                    } 
                    else{
                        mm[o]=1;
                    }
                 }
            }
            s=s1;
        }
    }
    
}
