package org.ryh.baptis.ui.page;

import org.jrebirth.af.api.key.UniqueKey;
import org.jrebirth.af.api.ui.Model;
import org.jrebirth.af.api.wave.Wave;
import org.jrebirth.af.core.command.basic.showmodel.DisplayModelWaveBean;
import org.jrebirth.af.core.command.basic.showmodel.ShowFadingModelCommand;
import org.jrebirth.af.core.key.Key;
import org.jrebirth.af.core.ui.simple.DefaultSimpleModel;
import org.ryh.baptis.beans.Page;
import org.ryh.baptis.ui.BaptisWaves;
import org.ryh.baptis.ui.result.ResultModel;
import org.ryh.baptis.ui.search.SearchModel;
import javafx.scene.layout.StackPane;

public class PageModel extends DefaultSimpleModel<StackPane>{

    private UniqueKey<? extends Model> currentModelKey;

    @Override
    protected void initModel() {
         listen(BaptisWaves.DO_SHOW_PAGE);
    }

    @Override
    protected void initSimpleView() {
        super.initSimpleView();
    }

    @SuppressWarnings("incomplete-switch")
	public void doShowPage(final Page page, final Wave wave) {

       final DisplayModelWaveBean waveBean = DisplayModelWaveBean.create()
                                                                  .childrenPlaceHolder(node().getChildren())
                                                                  .appendChild(false);

        switch (page) {

            case Search:
            	System.out.println("Search page is loaded");
                waveBean.showModelKey(Key.create(SearchModel.class));
                break;
            case Result:
            	System.out.println("Result page is loaded");
                waveBean.showModelKey(Key.create(ResultModel.class));
                break;
        }

        waveBean.hideModelKey(this.currentModelKey);

        this.currentModelKey = waveBean.showModelKey();
        callCommand(ShowFadingModelCommand.class, waveBean);
    }

    @Override
    protected void showView() {
        doShowPage(Page.Search, null);
    }

}
