  
<template>
    <div>
        <h3>공지사항</h3>
        <table>
            <tr>
                <td>글번호</td>
                <td><input type="text" :value="gongzi.gongziNo" readonly></td>
            </tr>
            <tr>
                <td>제목</td>
                <td><input type="text" :value="gongzi.title" readonly></td>
            </tr>
            <tr>
                <td>작성자</td>
                <td><input type="text" :value="gongzi.writer" readonly></td>
            </tr>
            <tr>
                <td>본문</td>
                <td><textarea cols="50" rows="20" :value="gongzi.description" readonly></textarea></td>
            </tr>
            
        </table>
    </div>
</template>

<script>
export default {
    name: 'GongziRead',
    props: {
        gongzi: {
            type: Object,
            required: true
        }
    }    
}
</script>