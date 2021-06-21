package services;

import java.io.File;
import java.io.Serializable;
import net.sf.jasperreports.engine.JRExporter;

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
    private static final String SEPARATOR = File.separator;
    //Indica o caminho do relatório
    private static final String REPORT_URL = null;
    //Indica o caminho do sub-relatório
    private static final String SUBREPORT_URL = "";
    private static final JRExporter exporter = null;
    //O arquivo que será gerado
    private static final File reportFile = null;
}
