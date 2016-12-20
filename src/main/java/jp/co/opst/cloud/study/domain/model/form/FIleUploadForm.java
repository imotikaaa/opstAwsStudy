package jp.co.opst.cloud.study.domain.model.form;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by user on 2016/10/07.
 */
@Data
public class FIleUploadForm {
    private MultipartFile fileData;
}
