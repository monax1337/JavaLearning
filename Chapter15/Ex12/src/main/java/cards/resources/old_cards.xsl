<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format">
    <xsl:template match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="card-page" page-width="21cm" page-height="29.7cm" margin="1cm">
                    <fo:region-body/>
                </fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="card-page">
                <fo:flow flow-name="xsl-region-body">
                    <xsl:apply-templates select="Old_Cards/Card">
                        <xsl:sort select="Year" data-type="number"/>
                    </xsl:apply-templates>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>

    <xsl:template match="Card">
        <fo:block break-after="page" font-family="Times New Roman">
            <fo:block font-size="16pt" font-weight="bold" space-after="5mm">Postcard</fo:block>
            <fo:block font-size="12pt" space-after="2mm">Theme: <xsl:value-of select="Theme"/></fo:block>
            <fo:block font-size="12pt" space-after="2mm">Type: <xsl:value-of select="Type"/></fo:block>
            <fo:block font-size="12pt" space-after="2mm">Sent: <xsl:value-of select="Type_Sent"/></fo:block>
            <fo:block font-size="12pt" space-after="2mm">Country: <xsl:value-of select="Country"/></fo:block>
            <fo:block font-size="12pt" space-after="2mm">Year: <xsl:value-of select="Year"/></fo:block>
            <fo:block font-size="12pt" space-after="2mm">Author: <xsl:value-of select="Author"/></fo:block>
            <fo:block font-size="12pt" space-after="2mm">Value: <xsl:value-of select="Valuable"/></fo:block>
        </fo:block>
    </xsl:template>
</xsl:stylesheet>
