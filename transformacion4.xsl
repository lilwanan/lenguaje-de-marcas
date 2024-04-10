<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
    <xsl:for-each select="Equipo/Miembro">
        <xsl:choose>

            <xsl:when test="@nivel='basica'">
                Tienes que trabajar mas
            </xsl:when>
            <xsl:when test="@nivel='premier'">
                Tienes acceso a la nueva PS6
            </xsl:when>
            <xsl:otherwise>
                Apuntate con nosotros
            </xsl:otherwise>

        </xsl:choose>
        
    </xsl:for-each>   




    </xsl:template>






</xsl:stylesheet>