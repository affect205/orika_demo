package ru.alexside.mapper;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.converter.builtin.PassThroughConverter;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.Type;
import ru.alexside.dto.ContactFull;
import ru.alexside.dto.RpoHeaderFull;
import ru.alexside.model.Contact;
import ru.alexside.model.GpoHeader;
import ru.alexside.model.RpoHeader;

import java.time.Instant;
import java.util.UUID;

/**
 * Created by Alex on 25.03.2018.
 */
public class JPAToDTOConverter {
    public static final MapperFacade FACADE;

    static {
        // https://github.com/orika-mapper/orika/issues/62
        MapperFactory mapperFactory = new DefaultMapperFactory
                .Builder()
                .dumpStateOnException(true)
                .compilerStrategy(new OrikaClassloader())
                .useAutoMapping(true)
                .build();

        mapperFactory.getConverterFactory().registerConverter(new PassThroughConverter(Instant.class));
        mapperFactory.getConverterFactory().registerConverter(new StringToUUIDConverter());

        mapperFactory.classMap(GpoHeader.class, GpoHeader.class)
                .byDefault()
                .register();

        mapperFactory.classMap(RpoHeader.class, RpoHeaderFull.class)
                .exclude("gpoHeader")
                .byDefault()
                .register();

        mapperFactory.classMap(Contact.class, ContactFull.class)
                .field("details", "contacts")
                .byDefault()
                .register();

        FACADE = mapperFactory.getMapperFacade();
    }

        private static class StringToUUIDConverter extends BidirectionalConverter<String, UUID> {
            @Override
            public UUID convertTo(String source, Type<UUID> destinationType, MappingContext mappingContext) {
                try {
                    return UUID.fromString(source);
                } catch (Exception e) {
                    return null;
                }
            }

            @Override
            public String convertFrom(UUID source, Type<String> destinationType, MappingContext mappingContext) {
                try {
                    return source.toString();
                } catch (Exception e) {
                    return null;
                }
            }
        }
}
