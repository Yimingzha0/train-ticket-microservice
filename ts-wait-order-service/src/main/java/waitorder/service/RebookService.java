package waitorder.service;

import edu.fudan.common.util.Response;
import org.springframework.http.HttpHeaders;
import waitorder.entity.RebookInfo;


/**
 * @author fdse
 */
public interface RebookService {
    Response rebook(RebookInfo info, HttpHeaders headers);
    Response payDifference(RebookInfo info,  HttpHeaders headers);
}
