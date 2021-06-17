# 动态代理

从JVM角度来说，动态代理是在运行时动态生成类字节码，并加载到JVM中

动态代理大致介绍两种

## JDK动态代理机制

在JAVA动态代理机制中InvocationHandler接口和Proxy类是核心

```java
 public static Object newProxyInstance(ClassLoader loader,
                                          Class<?>[] interfaces,
                                          InvocationHandler h)
        throws IllegalArgumentException
    {
        ......
    }
```