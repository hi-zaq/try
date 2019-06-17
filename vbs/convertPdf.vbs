Option Explicit
'**********************************************************************************
' ���T�v
'   ���s�t�@�C���Ɠ����K�w�ȉ���
'   Excel�AWord �t�@�C���� PDF �ɕϊ����Ďw�肵���t�H���_�ɏo�͂��܂��B
'
'   �� Office 2007 �ȏ�A�v�����^���g�p�ł�����ł̂ݓ��삵�܂��B
'**********************************************************************************
 
'==============================================================
' �ϐ��̐錾�A������
'==============================================================
 
'�t�H���_����p
Dim Fso
Dim objApl
Dim objFolder
Dim objFolderTo
Dim objFolderItems
Dim strCurrentPath
Dim obj
Dim crtFolderPath
Dim tmpFilePath
 
'Excel�p
Dim ExcelApp
Dim WordApp
Dim Doc
Dim Book
Dim Sheet
 

'�ύX�\�F�A�N�e�B�u�V�[�g�݂̂Ƃ��邩�ǂ����̃t���O�i0�F�I�t�^1�F�I���j
Dim ActiveSheetFlg
ActiveSheetFlg = 0
 
'�ύX�\�F�y�[�W�w��
'From �� 0 �ł���Ύw�肵�Ȃ�
Dim PageFrom
Dim PageTo
PageFrom = 0
PageTo = 0
 
'�ύX�\�F�ϊ����t�@�C�����폜���邩�ǂ����i0�F�폜���Ȃ��^1�F�폜�j
Dim DeleteFlg
DeleteFlg = 0
 
'==============================================================
' �����J�n
'==============================================================
 
'�P�D�t�@�C���I�u�W�F�N�g���쐬
Set Fso = CreateObject( "Scripting.FileSystemObject" )
 
'�P�|�P�D�R�s�[��
Dim copyTo
copyTo = InputBox("PDF�o�͐����͂��Ă��������B", "PDF�o�͐�","D:\work\temp\")
If Fso.FolderExists(copyTo) = false Then
    MsgBox("PDF�o�͐悪������܂���ł����B�����𒆒f���܂��B")
    ' �X�N���v�g�I��
    Wscript.Quit()
End If

'�Q�D���s�t�@�C�����i�[����Ă���p�X���擾
strCurrentPath = WScript.ScriptFullName
Set obj = Fso.GetFile( strCurrentPath )
Set obj = obj.ParentFolder
strCurrentPath = obj.Path
 
'�R�DExcel, Word �A�v���P�[�V�����I�u�W�F�N�g���쐬���܂��B
Set ExcelApp = CreateObject("Excel.Application")
Set WordApp = CreateObject("Word.Application")
 
'�S�D�V�F���A�v���P�[�V�����I�u�W�F�N�g���쐬���܂�
Set objApl = WScript.CreateObject("Shell.Application")
 
'�T�D���s�t�@�C���Ɠ����K�w�̃t�H���_�I�u�W�F�N�g���쐬���܂�
Set objFolder = objApl.NameSpace(strCurrentPath)
 
'�U�D���s�t�@�C���̐e�t�H���_���R�s�[��ɂȂ���΍쐬����
crtFolderPath = copyTo & Fso.GetBaseName(strCurrentPath)
Wscript.Echo "�p�X�F" & crtFolderPath
If Fso.FolderExists(crtFolderPath) = false Then
    Fso.CreateFolder(crtFolderPath)
End If
 
'�V�D�t�H���_�I�u�W�F�N�g����i�[����Ă���t�@�C���A�t�H���_���擾���܂��B
Set objFolderItems = objFolder.Items()
 
'�W�D�t�@�C���A�t�H���_�P�ʂ̏���
Call prcFolder (objFolder)
 
'�X�D�I������
ExcelApp.Quit()
WordApp.Quit()
Set ExcelApp = Nothing
Set WordApp = Nothing
Set objFolderItems = Nothing
Set objFolder = Nothing
Set objApl = Nothing
 
Wscript.Echo crtFolderPath & " �ɕϊ�����PDF���o�͂��܂����B"
 
 
 
'------------------------------------------------------------------------------------------
' ���T�u�v���O����
'   �t�H���_���Ɋ܂܂��t�@�C����t�H���_���������A
'   Excel�AWord �t�@�C���� PDF �t�@�C���ɕϊ�����B
'------------------------------------------------------------------------------------------
Sub prcFolder(objFolder)
    
    Dim tmpFolderPath
    Dim tmpFolderItems
    Dim crtFolderPathB
    Dim objFolderItemsB
    Dim objItem
    Dim i
    Set tmpFolderItems = objFolder.Items()
    
    ' �t�H���_���A�C�e���̑���
    For i=0 To tmpFolderItems.Count-1
        
        '�t�@�C������уt�H���_�I�u�W�F�N�g���擾
        Set objItem = tmpFolderItems.Item(i)
        'Wscript.Echo "�p�X�F" & objItem.Name
        
        '�t�@�C���A�t�H���_�̔���
        If objItem.IsFolder Then
        
            '�p�X��ޔ�
            tmpFolderPath = crtFolderPath
            
            '�������̃f�B���N�g�����p�X�Ɋ܂߂�
            crtFolderPath = crtFolderPath & "\" & objItem.Name
            
            ' �e�f�B���N�g�����Ȃ���΍쐬
            If Fso.FolderExists(crtFolderPath) = false Then
                Fso.CreateFolder(crtFolderPath)
            End If
            
            '�t�H���_�ł���΍ċN���������{
            Set objFolderItemsB = objItem.GetFolder
            Call prcFolder (objFolderItemsB)
            
            '�p�X��߂�
            crtFolderPath = tmpFolderPath
        
        ' �e�f�B���N�g�����Ȃ���΍쐬
        Else If Fso.FolderExists(crtFolderPath) = false Then
            Fso.CreateFolder(crtFolderPath)
        End If
        
        ' Excel�̏ꍇ
        If Fso.GetExtensionName(objItem.Name) = "xls" Or Fso.GetExtensionName(objItem.Name) = "xlsx" Then
            
            ' �o�̓p�X
            tmpFilePath = Fso.GetParentFolderName(objItem.Path) & "\" & Fso.GetBaseName(objItem.Name) & ".pdf"
            
            Set Book = ExcelApp.Workbooks.Open( objItem.Path )
            If Err.Number <> 0 Then
                ' �I��( �J�� )
                ExcelApp.Quit()
                Wscript.Echo Err.Description & vbCrLf & strCurrentPath
                ' �X�N���v�g�I��
                Wscript.Quit()
            End If
            on error goto 0
        
            if ActiveSheetFlg = 1 Then
                ' �A�N�e�B�u�V�[�g�w��
                Set Sheet = Book.ActiveSheet
                If Err.Number <> 0 Then
                    ' �I��( �J�� )
                    ExcelApp.Quit()
                    Wscript.Echo Err.Description & vbCrLf & strCurrentPath
                    ' �X�N���v�g�I��
                    Wscript.Quit()
                End If
                on error goto 0
                Call Sheet.ExportAsFixedFormat(0, tmpFilePath)

            Else if PageFrom = 0 Then
                ' �u�b�N�S��
                Call Book.ExportAsFixedFormat(0, tmpFilePath, 0)
            Else
                ' �y�[�W�w��
                Call Book.ExportAsFixedFormat(0, tmpFilePath, 0, False, False, PageFrom, PageTo, False)
            End if
        End if
        
        ' �I��( �J�� )
        ExcelApp.DisplayAlerts = False
        Book.Close
        ExcelApp.DisplayAlerts = True
        
        End If
        
        ' Word�̏ꍇ
        If Fso.GetExtensionName(objItem.Name) = "doc" Or Fso.GetExtensionName(objItem.Name) = "docx" Then
        
            ' �o�̓p�X
            tmpFilePath = Fso.GetParentFolderName(objItem.Path) & "\" & Fso.GetBaseName(objItem.Name) & ".pdf"
            
            Set Doc = WordApp.Documents.Open( objItem.Path, true)
        
            If Err.Number <> 0 Then
                ' �I��( �J�� )
                WordApp.Quit()
                Wscript.Echo Err.Description & vbCrLf & strCurrentPath
                ' �X�N���v�g�I��
                Wscript.Quit()
            End If
            on error goto 0
            
            Call WordApp.ActiveDocument.ExportAsFixedFormat( tmpFilePath,17,False)
            
            ' �I��( �J�� )
            WordApp.DisplayAlerts = False
            Doc.Close
            WordApp.DisplayAlerts = True
        
        End If
        
        ' �ϊ������t�@�C�����ړ�
        If Fso.GetExtensionName(objItem.Name) = "xls" Or Fso.GetExtensionName(objItem.Name) = "xlsx" Or Fso.GetExtensionName(objItem.Name) = "doc" Or Fso.GetExtensionName(objItem.Name) = "docx" Then
            ' PDF�̂݃R�s�[
            Fso.CopyFile tmpFilePath, crtFolderPath & "\", true
            ' �R�s�[��ɍ폜
            Fso.DeleteFile tmpFilePath
            
            if DeleteFlg = 1 Then
            ' ���t�@�C�����폜
                Fso.DeleteFile objItem.Path
            End If
        End If
    
        End If
    
    Next
    
    ' �I��( �J�� )
    Set objItem = Nothing
    Set objFolderItemsB = Nothing
 
End Sub