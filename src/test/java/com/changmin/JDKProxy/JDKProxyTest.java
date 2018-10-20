package com.changmin.JDKProxy;

import org.testng.annotations.Test;
import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class JDKProxyTest {
    @Test
    public void test() throws IOException {
        ProductService productService = new ProductServiceImpl();
        ProductService proxy = (ProductService) new JDKInvocationHandler().getInstance(productService);
        proxy.addProduct("iPhone");
        // 这里我们将jdk生成的代理类输出了出来，方便后面分析使用
        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{productService.getClass()});

        FileOutputStream os = new FileOutputStream("Proxy0.class");
        os.write(bytes);
        os.close();

    }
}
