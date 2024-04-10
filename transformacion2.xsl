<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">


    <xsl:template match="/">
        <html>
        <head>
            <title>Tabla</title>
        </head>
        <body>
        <table border="1">
        
            <th>Nombre</th>
            <th>Peso</th>
            <th>edificio</th>
        
        <xsl:for-each select="inventario/producto">
            <xsl:if test="peso &lt; 12">
            <tr>
                <td><xsl:value-of select="nombre"/></td>
                <td><xsl:value-of select="peso"/></td>
                <td><xsl:value-of select="lugar/@edificio"/></td>
            </tr>
            </xsl:if>
        </xsl:for-each>
        </table>
        </body>
        </html>
    </xsl:template>

</xsl:stylesheet>