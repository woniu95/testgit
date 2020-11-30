package src;

import com.sun.tools.attach.*;

import java.io.IOException;
import java.util.Arrays;

/**
 * @program: instrumemtationTest
 * @description: 把 agent attach 到目标 jvm
 * @author: 王强
 * @create: 2020-09-17 11:53
 */
public class AttachMain {


    public static void main(String[] args) {

        System.out.println(Arrays.toString(args));
        try {
            VirtualMachine vm =  VirtualMachine.attach(args[0]);
            vm.loadAgent("E:\\wqdaily\\codespaces\\instrumemtationTest\\target\\instrumemtationTest-1.0-SNAPSHOT.jar");

        } catch (AttachNotSupportedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (AgentLoadException e) {
            e.printStackTrace();
        } catch (AgentInitializationException e) {
            e.printStackTrace();
        }
    }

}
