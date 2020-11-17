<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<body>
				<h2>Osztaly</h2>
				<table>
					<tr>
						<th>keresztnev</th>
						<th>vezeteknev</th>
						<th>becenev</th>
						<th>fizetes</th>
					</tr>

					<xsl:for-each select="osztaly/alkalmazott">
						<tr>
							<td><xsl:value-of select="keresztnev"></xsl:value-of></td>
							<td><xsl:value-of select="vezeteknev"></xsl:value-of></td>
							<td><xsl:value-of select="becenev"></xsl:value-of></td>
							<td><xsl:value-of select="fizetes"></xsl:value-of></td>
						</tr>
					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>