package afkt.project.ui.activity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gavin.com.library.StickyDecoration;
import com.gavin.com.library.listener.GroupListener;

import java.util.ArrayList;
import java.util.List;

import afkt.project.R;
import afkt.project.base.app.BaseToolbarActivity;
import afkt.project.model.bean.ItemStickyBean;
import afkt.project.ui.adapter.ItemStickyAdapter;
import butterknife.BindView;
import dev.temp.ChineseUtils;
import dev.utils.app.ResourceUtils;
import dev.utils.app.SizeUtils;
import dev.utils.common.DateUtils;
import dev.utils.common.RandomUtils;

/**
 * detail: RecyclerView 吸附效果
 * @author Ttt
 * <pre>
 *     RecyclerView 实现顶部吸附效果
 *     @see <a href="https://github.com/Gavin-ZYX/StickyDecoration"/>
 * </pre>
 */
public class ItemStickyActivity extends BaseToolbarActivity {

    // = View =
    @BindView(R.id.vid_bvr_recy)
    RecyclerView vid_bvr_recy;
    // 适配器
    ItemStickyAdapter itemStickyAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.base_view_recyclerview;
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        ViewGroup parent = (ViewGroup) vid_bvr_recy.getParent();
//        // 根布局处理
//        ViewHelper.get().setPadding(parent, 0)
//                .setBackgroundColor(parent, ResourceUtils.getColor(R.color.color_33));
//    }

    @Override
    public void initValues() {
        super.initValues();

        GroupListener groupListener = new GroupListener() {
            @Override
            public String getGroupName(int position) {
                if (itemStickyAdapter != null) {
                    try {
                        return itemStickyAdapter.getData().get(position).timeTile;
                    } catch (Exception e) {
                    }
                }
                return " ";
            }
        };
        StickyDecoration decoration = StickyDecoration.Builder.init(groupListener)
                .setGroupBackground(ResourceUtils.getColor(R.color.color_f7))
                .setGroupTextColor(ResourceUtils.getColor(R.color.color_33))
                .setGroupTextSize(SizeUtils.spConvertPx(15.0f))
                .setTextSideMargin(SizeUtils.dipConvertPx(10.0f))
                .build();

        // 初始化布局管理器、适配器
        itemStickyAdapter = new ItemStickyAdapter(getList());
        vid_bvr_recy.setLayoutManager(new LinearLayoutManager(this));
        vid_bvr_recy.setAdapter(itemStickyAdapter);
        vid_bvr_recy.addItemDecoration(decoration);
    }

    private List<ItemStickyBean> getList() {
        List<ItemStickyBean> lists = new ArrayList<>();

        long time = System.currentTimeMillis();

        for (int i = 0; i < 8; i++) {
            lists.add(new ItemStickyBean(ChineseUtils.getRandomWord(RandomUtils.getRandom(3, 12)), time));
        }

        time -= DateUtils.DAY;
        for (int i = 0; i < 5; i++) {
            lists.add(new ItemStickyBean(ChineseUtils.getRandomWord(RandomUtils.getRandom(3, 12)), time));
        }

        time -= DateUtils.DAY * 3;
        for (int i = 0; i < 4; i++) {
            lists.add(new ItemStickyBean(ChineseUtils.getRandomWord(RandomUtils.getRandom(3, 12)), time));
        }

        time -= DateUtils.DAY * 2;
        for (int i = 0; i < 6; i++) {
            lists.add(new ItemStickyBean(ChineseUtils.getRandomWord(RandomUtils.getRandom(3, 12)), time));
        }

        time -= DateUtils.DAY;
        for (int i = 0; i < 7; i++) {
            lists.add(new ItemStickyBean(ChineseUtils.getRandomWord(RandomUtils.getRandom(3, 12)), time));
        }

        time -= DateUtils.DAY * 10;
        for (int i = 0; i < 7; i++) {
            lists.add(new ItemStickyBean(ChineseUtils.getRandomWord(RandomUtils.getRandom(3, 12)), time));
        }

        time -= DateUtils.DAY * 4;
        for (int i = 0; i < 10; i++) {
            lists.add(new ItemStickyBean(ChineseUtils.getRandomWord(RandomUtils.getRandom(3, 12)), time));
        }
        return lists;
    }
}