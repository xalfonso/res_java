package eas.com;

import ec.com.kruger.utilitario.loggin.resources.MessageResolver;

public class DummyMessages {
    public static final MessageResolver MESSAGE_RESOLVER = new MessageResolver("Dummy");
    public static final String value = MESSAGE_RESOLVER.getString("some.dummy.value");

}
