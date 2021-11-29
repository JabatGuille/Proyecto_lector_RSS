# Lenguajes de marcas

Te han encargado crear un lector de [feeds RSS](https://es.wikipedia.org/wiki/RSS) que funcione en línea de comandos.

El programa tendrá un interfaz como este:

```
RSS
---
1. Nuevo feed
2. Borrar feed
3. Mostrar titulares de un feed
4. Salir
```

## Restricciones

El programa estará escrito en Java usando [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/).

### Nuevo feed

El programa pedirá la URL del feed RSS y la almacenará en un fichero llamado `feeds.xml` con la siguiente estructura:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">
  <xs:element name="feeds" type="tipo_feeds"/>

  <xs:complexType name="tipo_feeds">
    <xs:sequence>
      <xs:element name="feed" type="tipo_feed" maxOccurs="unbounded"/>
    </xs:sequence>
  </xs:complexType>

  <xs:complexType name="tipo_feed">
    <xs:sequence>
      <xs:element name="titulo" type="xs:string"/>
      <xs:element name="url" type="xs:string"/>
    </xs:sequence>
  </xs:complexType>
</xs:schema>
```

### Borrar feed

El programa mostrará la lista de feeds almacenados en el fichero `feeds.xml` y pedirá al usuario que elija uno para eliminarlo del archivo.

### Mostrar titulares de un feed

El programa mostrará la lista de feeds almacenados en el fichero `feeds.xml` y pedirá al usuario que elija uno. 

Después, descargará los datos de ese feed y mostrará los primeros 5 items disponibles.

## Ejemplos de feeds RSS

- [ELPAÍS.com - Titulares - Lo último](https://ep00.epimg.net/rss/tags/ultimas_noticias.xml)
- [Xataka](http://feeds.weblogssl.com/xataka2)
