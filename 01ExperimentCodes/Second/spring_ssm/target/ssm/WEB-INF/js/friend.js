var url = "/post";
function addFriend() {
    $('#myModal_add').modal('show')
}
function alterFriend() {
    let m = $(":checked[name='alter']");
    if(m.length===0){
        alert('请选择需要更改的friend')
        return
    }
    let _alterFriend = m.parents('tr').find('td')
    ab = [];
    for(i=0;i<_alterFriend.length-1;i++)
    {
        ab.push(_alterFriend[i].innerText);
    }
    // ["锁语梦", "男", "13985904612", "2008-06-26", "18948576903", "18525917840", "青岛市"]
    $('#name1')[0].value = ab[0];
    $("#phoneNum1")[0].value = ab[2];
    if(ab[1]=='男'){
    $("#gender_11").prop("checked", true)
    }
    else{
        $("#gender_12").prop("checked", true)
    }

    $("#friend_birth1")[0].value = ab[3];
    $("#friend_wechat1")[0].value = ab[4];
    $('#friend_QQ1')[0].value = ab[5];
    $("#friend_address1")[0].value = ab[6];
    $('#myModal_alter').modal('show')

}
function alterFriendSendForm(){
    let m = $(":checked[name='alter']");
    $.ajax({
            type: "POST",
            url: url,
            data:$("#alter_form").serialize()+'&id='+m[0].value,
            dataType:"json",
            async:true,
            success:(data)=>{alert('成功')}
        }
    )
}
function addFriendSendForm(){
   $.ajax({
           type: "POST",
           url: url,
       data:$("#add_form").serialize(),
       dataType:"json",
           async:true,
       success:(data)=>{alert('成功')}
       }
       )
}

function deleteFriend() {
    let friend_id = [];
    let m = $(":checked[name='delete']");
    for(i=0;i<m.length;i++){
        friend_id.push(m[i].value)
    }
    let ab = [];
    for(i=0;i<m.length;i++)
    {
        ab.push(m[i].value)
    }

    $.ajax({
        type: "POST",
        url: url,
        traditional:true,
        data:{
            post:ab,
            type:"delete"
        },
        dataType: "json",
        async:false
    },success=(data)=>{
        console.log("成功了");
    },error=()=>{
        console.log("失败了");
    });
}

