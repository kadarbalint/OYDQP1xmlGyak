<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" />
    <xsl:template match="/">
        <html>
            <body>
                <table>
                    <th>
                        <td>Rendszám</td>
                        <td>Ár</td>
                    </th>
                    <xsl:for-each select="//auto">
                        <xsl:sort select="ar" data-type="number" order="ascending" />
                        <tr>
                            <td>    
                                <xsl:value-of select="@rsz" />
                            </td>
                            <td>
                                <xsl:value-of select="ar" />
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>