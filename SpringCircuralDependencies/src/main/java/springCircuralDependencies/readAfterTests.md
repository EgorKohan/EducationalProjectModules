#4.1. Redesign
When we have a circular dependency, it’s likely we have a design problem and that the responsibilities are not well separated. We should try to redesign the components properly so that their hierarchy is well designed and there is no need for circular dependencies.

However, there are many possible reasons we may not be able to do a redesign, such as legacy code, code that has already been tested and cannot be modified, not enough time or resources for a complete redesign, etc. If we can't redesign the components, we can try some workarounds.

#4.2. Use @Lazy
A simple way to break the cycle is by telling Spring to initialize one of the beans lazily. So, instead of fully initializing the bean, it will create a proxy to inject it into the other bean. The injected bean will only be fully created when it’s first needed.

To try this with our code, we can change the CircularDependencyA:

#4.3. Use Setter/Field Injection
One of the most popular workarounds, and also what the Spring documentation suggests, is using setter injection.

Simply put, we can address the problem by changing the ways our beans are wired — to use setter injection (or field injection) instead of constructor injection. This way, Spring creates the beans, but the dependencies are not injected until they are needed.

So, let's change our classes to use setter injections and add another field (message) to CircularDependencyB so we can make a proper unit test:

#5. Conclusion
There are many ways to deal with circular dependencies in Spring.

We should first consider redesigning our beans so there is no need for circular dependencies. That's because circular dependencies are usually a symptom of a design that can be improved.

But if we absolutely need circular dependencies in our project, we can follow some of the workarounds suggested here.

The preferred method is using setter injections. But there are other alternatives, generally based on stopping Spring from managing the initialization and injection of the beans as well as accomplishing this ourselves using different strategies.

The examples in this article can be found in the GitHub project. (May find inn baeldung directory)