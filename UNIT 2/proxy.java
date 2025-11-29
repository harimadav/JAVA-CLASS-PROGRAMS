package proxy;

import java.lang.reflect.*;

//Step 1: Define an Interface
interface Service {
 void performTask();
}

//Step 2: Real implementation of Service
class RealService implements Service {
 public void performTask() {
     System.out.println("Performing the actual task...");
 }
}

//Step 3: InvocationHandler (controls what proxy will do)
class ServiceInvocationHandler implements InvocationHandler {
 private final Service realService;

 // Constructor to pass the real object
 public ServiceInvocationHandler(Service realService) {
     this.realService = realService;
 }

 // This method is called whenever a method on the proxy is invoked
 public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
     System.out.println("Before method call: Checking security...");
     
     // Call the actual method on the real object
     Object result = method.invoke(realService, args);

     System.out.println("After method call: Logging the action...");
     return result;
 }
}

public class proxy  {
 public static void main(String[] args) {
     // Step 4: Create the real object
     Service realService = new RealService();

     // Step 5: Create a proxy for the realService
     Service proxyInstance = (Service) Proxy.newProxyInstance(
         Service.class.getClassLoader(),          // ClassLoader
         new Class[] { Service.class },           // Interfaces to implement
         new ServiceInvocationHandler(realService) // Handler that defines proxy behavior
     );

     // Step 6: Call method via proxy (not directly on realService)
     proxyInstance.performTask();
 }
}

