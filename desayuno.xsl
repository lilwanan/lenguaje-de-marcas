<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
               version="1.0">
<xsl:template match="/">
    La descripcion de los desayunos
    <xsl:value-of select="//desayuno/descripcion"/>
    
</xsl:template>

</xsl:stylesheet>