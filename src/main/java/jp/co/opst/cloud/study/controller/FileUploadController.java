package jp.co.opst.cloud.study.controller;


import jp.co.opst.cloud.study.domain.helper.DisplayHostHelper;
import jp.co.opst.cloud.study.domain.model.dto.Image;
import jp.co.opst.cloud.study.domain.model.form.FileUploadForm;
import jp.co.opst.cloud.study.domain.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * ファイルアップロード機能
 * Created by maaya on 2016/12/12.
 */
@Controller
@RequestMapping("/")
@Slf4j
public class FileUploadController {

    @Autowired
    private DemoService demoService;
    @Autowired
    private DisplayHostHelper displayHostHelper;

    /**
     * 現在表示可能な画像の一覧を表示する画面を返却する
     *
     * @param model
     * @return
     */
    @GetMapping(value = "/gallery")
    public String gallery(Model model) {
        log.debug("写真一覧表示API");

        //TODO 現在使用できる写真を取得する

        //TODO サムネイルリストとフルサイズリストを作成する
        //[使い方] サービスを作成する場合はautowiredしてから利用します。autowired対象のクラスに@Componentを付与してください。
        List<Image> images = demoService.makeDemoData(); //TODO とってきたデータを入れてください

        //画面設定
        model.addAttribute("images", images);
        model.addAttribute("dispIp", displayHostHelper.createIp());
        model.addAttribute("fileUploadForm", new FileUploadForm());
        return "index";
    }


    /**
     * ファイルアップロード処理を行う
     *
     * @param fileData uploadファイルデータ
     * @param model 表示に必要なデータモデル
     * @return 画面表示
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@RequestParam MultipartFile fileData, Model model) {
        log.debug("ファイルアップロード");

        //TODO formで受け取ったfileをS3へ

        //TODO サムネイル画像の作成と保存及び元画像の保存

        //一覧データの取得と表示
        return gallery(model);
    }

}
