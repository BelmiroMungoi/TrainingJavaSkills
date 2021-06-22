package services;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletContext;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author bbm29
 */
public class ReportService implements Serializable {

    //Indica a pasta onde estão os relatórios
    private static final String FOLDER_REPORTS = "/reports";
    //Indica a pasta dos sub-relatóriois
    private static final String SUBREPORTS_DIR = "SUBREPORTS_DIR";
    //Define o separador das pastas / ou \
    private String SEPARATOR = File.separator;
    //Indica o caminho do relatório
    private String REPORT_URL = null;
    //Indica o caminho do sub-relatório
    private String SUBREPORT_URL = "";
    //Indica o tipo de exportacao pdf/sheets...
    private JRExporter exporter = null;
    //O arquivo que será gerado
    private File reportFile = null;

    //Metodo para gerar o relatorio
    public String generateReport(List<?> dataList, HashMap reportParam,
            String reportName, String finalReport, ServletContext context) throws Exception {

        //cria uma lista de dados de beans que carregam os dados para o relatorio
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(dataList);

        //Fornece o caminho onde esta a pasta dos relatorios
        String url = context.getRealPath(FOLDER_REPORTS);

        //Traz o ficheiro do relatorio .jasper
        File file = new File(url + SEPARATOR + reportName + ".jasper");

        if (url == null || (url != null && url.isEmpty())
                || !file.exists()) {
            url = this.getClass().getResource(FOLDER_REPORTS).getPath();
            SEPARATOR = "";
        }

        //Caminho para imagens no relatorio
        reportParam.put("REPORT_PARAMETERS_IMG", url);

        //indica o caminho completo ate o relatorio
        String completeURL = url + SEPARATOR + reportName + ".jasper";

        //Vai carregar o relatorio
        JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(completeURL);

        //Irá setar o caminho SUBREPORT_DIR com o caminho fisico para sub relatorio
        SUBREPORT_URL = url + SEPARATOR;
        reportParam.put(SUBREPORTS_DIR, SUBREPORT_URL);

        //Vai carregar o ficheiro
        JasperPrint printer = JasperFillManager.fillReport(reportName, reportParam, dataSource);

        //Define o tipo de ficheiro a ser exportado
        exporter = new JRPdfExporter();

        //O caminho do relatorio gerado 
        REPORT_URL = url + SEPARATOR + finalReport + ".pdf";

        //Cria um novo arquivo ao exportar relatorio
        reportFile = new File(REPORT_URL);

        //Prepara a impressao do relatorio
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, printer);
        //SAida
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE, reportFile);

        //Executa a exportacao do relatorio
        exporter.exportReport();

        //Remove o arquivo do servidor apos o download
        reportFile.delete();
        return REPORT_URL;
    }
}
