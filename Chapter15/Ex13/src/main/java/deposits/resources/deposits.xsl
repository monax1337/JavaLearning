<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format">
    <xsl:template match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="bank-page" page-width="21cm" page-height="29.7cm" margin="1cm">
                    <fo:region-body/>
                </fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="bank-page">
                <fo:flow flow-name="xsl-region-body">
                    <fo:table table-layout="fixed" width="100%">
                        <fo:table-column column-width="15%"/>
                        <fo:table-column column-width="10%"/>
                        <fo:table-column column-width="10%"/>
                        <fo:table-column column-width="15%"/>
                        <fo:table-column column-width="15%"/>
                        <fo:table-column column-width="10%"/>
                        <fo:table-column column-width="15%"/>
                        <fo:table-column column-width="10%"/>
                        <fo:table-header>
                            <fo:table-row>
                                <fo:table-cell><fo:block font-weight="bold">Name</fo:block></fo:table-cell>
                                <fo:table-cell><fo:block font-weight="bold">Country</fo:block></fo:table-cell>
                                <fo:table-cell><fo:block font-weight="bold">Type</fo:block></fo:table-cell>
                                <fo:table-cell><fo:block font-weight="bold">Depositor</fo:block></fo:table-cell>
                                <fo:table-cell><fo:block font-weight="bold">Account id</fo:block></fo:table-cell>
                                <fo:table-cell><fo:block font-weight="bold">Amount on deposit</fo:block></fo:table-cell>
                                <fo:table-cell><fo:block font-weight="bold">Profitability</fo:block></fo:table-cell>
                                <fo:table-cell><fo:block font-weight="bold">Time constraints</fo:block></fo:table-cell>
                            </fo:table-row>
                        </fo:table-header>
                        <fo:table-body>
                            <xsl:apply-templates select="Bank/Deposit"/>
                        </fo:table-body>
                    </fo:table>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>

    <xsl:template match="Deposit">
        <fo:table-row>
            <fo:table-cell padding="2mm" border="solid 1px">
                <fo:block><xsl:value-of select="Name"/></fo:block>
            </fo:table-cell>
            <fo:table-cell padding="2mm" border="solid 1px">
                <fo:block><xsl:value-of select="Country"/></fo:block>
            </fo:table-cell>
            <fo:table-cell padding="2mm" border="solid 1px">
                <fo:block><xsl:value-of select="Type"/></fo:block>
            </fo:table-cell>
            <fo:table-cell padding="2mm" border="solid 1px">
                <fo:block><xsl:value-of select="Depositor"/></fo:block>
            </fo:table-cell>
            <fo:table-cell padding="2mm" border="solid 1px">
                <fo:block><xsl:value-of select="Account_id"/></fo:block>
            </fo:table-cell>
            <fo:table-cell padding="2mm" border="solid 1px">
                <fo:block><xsl:value-of select="Amount_on_deposit"/></fo:block>
            </fo:table-cell>
            <fo:table-cell padding="2mm" border="solid 1px">
                <fo:block><xsl:value-of select="Profitability"/></fo:block>
            </fo:table-cell>
            <fo:table-cell padding="2mm" border="solid 1px">
                <fo:block><xsl:value-of select="Time_constraints"/></fo:block>
            </fo:table-cell>
        </fo:table-row>
    </xsl:template>
</xsl:stylesheet>
