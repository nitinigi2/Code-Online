let editor;

let sample_C_Code = '#include <stdio.h>\n' +
                    'int main() {\n' +
                    '// printf() displays the string inside quotation\n' +
                        '\tprintf("Hello, World!");\n' +
                        '\treturn 0;\n' +
                     '}\n';
window.onload = function() {
    editor = ace.edit("editor");
    editor.setTheme("ace/theme/monokai");
    editor.setFontSize(15);
    editor.setValue(sample_C_Code);
    editor.session.setMode("ace/mode/c_cpp");
}

function changeLanguage() {
    let language = $("#languages").val();

    let sample_CPlus_code = '#include<iostream>\n' +
                            'using namespace std;\n' +
                            '// main function -\n' +
                            '// where the execution of program begins\n' +
                            'int main(){\n' +
                            '\t// prints hello world\n' +
                            '\tcout<<"Hello World";\n' +
                            '\treturn 0;\n\n' +

                            '}';

    let sample_Java_Code = 'import java.util.*;\n\n' +

                            'class Main{\n\n' +

                            'public static void main(String[] args){\n' +
                                 '\tSystem.out.println("Hello World");\n' +
                            '}}';

    if(language == 'c'){
        editor.setValue(sample_C_Code);
        editor.session.setMode("ace/mode/c_cpp");
    }
    else if(language == 'c++'){
        editor.setValue(sample_CPlus_code);
        editor.session.setMode("ace/mode/c++");
    }
    else if(language == 'python'){
        editor.session.setMode("ace/mode/python");
    }
    else if(language == 'java'){
        editor.setValue(sample_Java_Code);
        editor.session.setMode("ace/mode/java");
    }
}

function changeTheme(){
    let theme = $("#themes").val();

    if(theme == 'twilight') editor.setTheme("ace/theme/twilight");
    if(theme == 'terminal') editor.setTheme("ace/theme/terminal");
    if(theme == 'monokai') editor.setTheme("ace/theme/monokai");
    if(theme == 'chrome') editor.setTheme("ace/theme/chrome");
}

function executeCode() {
    $.ajax({

        url: "http://localhost:8081/run",

        method: "POST",

        contentType: "application/json",

        data : JSON.stringify({ "language": $("#languages").val(), "code" : editor.getSession().getValue() }),

        success: function(response) {
            $(".output").text(response)
        }


    })
}

function clearCode(){
    changeLanguage();
}