/**
 *
 */
$(function() {
  // 候補リストに表示するデータを配列で準備
  var data = [ 'accepts', 'action_name', 'add', 'add_column', 'add_index',
      'add_timestamps', 'after_create', 'after_destroy', 'after_filter', 'all' ];

  // オートコンプリート機能を適用
  $('#keyword').autocomplete({
    source : data
  });
});
