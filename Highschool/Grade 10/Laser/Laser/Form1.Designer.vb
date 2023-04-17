<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class Form1
    Inherits System.Windows.Forms.Form

    'Form overrides dispose to clean up the component list.
    <System.Diagnostics.DebuggerNonUserCode()> _
    Protected Overrides Sub Dispose(ByVal disposing As Boolean)
        Try
            If disposing AndAlso components IsNot Nothing Then
                components.Dispose()
            End If
        Finally
            MyBase.Dispose(disposing)
        End Try
    End Sub

    'Required by the Windows Form Designer
    Private components As System.ComponentModel.IContainer

    'NOTE: The following procedure is required by the Windows Form Designer
    'It can be modified using the Windows Form Designer.  
    'Do not modify it using the code editor.
    <System.Diagnostics.DebuggerStepThrough()> _
    Private Sub InitializeComponent()
        Me.components = New System.ComponentModel.Container()
        Me.lblaser = New System.Windows.Forms.Label()
        Me.tmrlaser = New System.Windows.Forms.Timer(Me.components)
        Me.SuspendLayout()
        '
        'lblaser
        '
        Me.lblaser.BackColor = System.Drawing.Color.Black
        Me.lblaser.Location = New System.Drawing.Point(251, 352)
        Me.lblaser.Name = "lblaser"
        Me.lblaser.Size = New System.Drawing.Size(10, 81)
        Me.lblaser.TabIndex = 0
        '
        'tmrlaser
        '
        Me.tmrlaser.Interval = 10
        '
        'Form1
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(8.0!, 16.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(508, 426)
        Me.Controls.Add(Me.lblaser)
        Me.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle
        Me.KeyPreview = True
        Me.MinimizeBox = False
        Me.Name = "Form1"
        Me.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen
        Me.Text = "Form1"
        Me.ResumeLayout(False)

    End Sub
    Friend WithEvents lblaser As System.Windows.Forms.Label
    Friend WithEvents tmrlaser As System.Windows.Forms.Timer

End Class
