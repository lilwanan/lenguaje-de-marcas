<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">


    <xsl:template match="/">
        <html>
        <head>
            <title>Tabla</title>
        </head>
        <body>

        
        <xsl:for-each select="inventario/producto">
            
                
            
            <xsl:if test="lugar/@edificio='A'">
            <table border="1">
                <caption>Edificio A</caption>
                <th>Nombre</th>
                <th>Peso</th>
                <th>Aula</th>

                <tr>
                <td><xsl:value-of select="nombre"/></td>
                <td><xsl:value-of select="peso"/></td>
                <td><xsl:value-of select="lugar/aula"/></td>
                </tr>
            </table>
            </xsl:if>

            <xsl:if test="lugar/@edificio='B'">
            <table border="1">

                <caption>Edificio B</caption>
                <th>Nombre</th>
                <th>Peso</th>
                <th>Aula</th>

                <tr>
                <td><xsl:value-of select="nombre"/></td>
                <td><xsl:value-of select="peso"/></td>
                <td><xsl:value-of select="lugar/aula"/></td>
                </tr>
            </table>
            </xsl:if>

        </xsl:for-each>
        
        </body>
        </html>
    </xsl:template>

</xsl:stylesheet>