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
        Me.btnAddOne = New System.Windows.Forms.Button()
        Me.btnAddTwo = New System.Windows.Forms.Button()
        Me.btnAddThree = New System.Windows.Forms.Button()
        Me.lblOne = New System.Windows.Forms.Label()
        Me.lblTwo = New System.Windows.Forms.Label()
        Me.lblThree = New System.Windows.Forms.Label()
        Me.btnExit = New System.Windows.Forms.Button()
        Me.btnMinusOne = New System.Windows.Forms.Button()
        Me.Button5 = New System.Windows.Forms.Button()
        Me.Button6 = New System.Windows.Forms.Button()
        Me.SuspendLayout()
        '
        'btnAddOne
        '
        Me.btnAddOne.Location = New System.Drawing.Point(12, 13)
        Me.btnAddOne.Name = "btnAddOne"
        Me.btnAddOne.Size = New System.Drawing.Size(50, 35)
        Me.btnAddOne.TabIndex = 0
        Me.btnAddOne.Text = "+ One"
        Me.btnAddOne.UseVisualStyleBackColor = True
        '
        'btnAddTwo
        '
        Me.btnAddTwo.Location = New System.Drawing.Point(131, 13)
        Me.btnAddTwo.Name = "btnAddTwo"
        Me.btnAddTwo.Size = New System.Drawing.Size(49, 35)
        Me.btnAddTwo.TabIndex = 1
        Me.btnAddTwo.Text = "+ Two"
        Me.btnAddTwo.UseVisualStyleBackColor = True
        '
        'btnAddThree
        '
        Me.btnAddThree.Location = New System.Drawing.Point(242, 12)
        Me.btnAddThree.Name = "btnAddThree"
        Me.btnAddThree.Size = New System.Drawing.Size(57, 35)
        Me.btnAddThree.TabIndex = 2
        Me.btnAddThree.Text = "+ Three"
        Me.btnAddThree.UseVisualStyleBackColor = True
        '
        'lblOne
        '
        Me.lblOne.BackColor = System.Drawing.Color.DodgerBlue
        Me.lblOne.Font = New System.Drawing.Font("Modern No. 20", 36.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.lblOne.Location = New System.Drawing.Point(13, 89)
        Me.lblOne.Name = "lblOne"
        Me.lblOne.Size = New System.Drawing.Size(112, 50)
        Me.lblOne.TabIndex = 3
        '
        'lblTwo
        '
        Me.lblTwo.BackColor = System.Drawing.Color.DodgerBlue
        Me.lblTwo.Font = New System.Drawing.Font("Modern No. 20", 36.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.lblTwo.Location = New System.Drawing.Point(131, 89)
        Me.lblTwo.Name = "lblTwo"
        Me.lblTwo.Size = New System.Drawing.Size(110, 50)
        Me.lblTwo.TabIndex = 4
        '
        'lblThree
        '
        Me.lblThree.BackColor = System.Drawing.Color.DodgerBlue
        Me.lblThree.Font = New System.Drawing.Font("Modern No. 20", 36.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.lblThree.Location = New System.Drawing.Point(247, 89)
        Me.lblThree.Name = "lblThree"
        Me.lblThree.Size = New System.Drawing.Size(108, 50)
        Me.lblThree.TabIndex = 5
        '
        'btnExit
        '
        Me.btnExit.Location = New System.Drawing.Point(131, 176)
        Me.btnExit.Name = "btnExit"
        Me.btnExit.Size = New System.Drawing.Size(82, 23)
        Me.btnExit.TabIndex = 6
        Me.btnExit.Text = "EXIT"
        Me.btnExit.UseVisualStyleBackColor = True
        '
        'btnMinusOne
        '
        Me.btnMinusOne.Location = New System.Drawing.Point(68, 13)
        Me.btnMinusOne.Name = "btnMinusOne"
        Me.btnMinusOne.Size = New System.Drawing.Size(50, 35)
        Me.btnMinusOne.TabIndex = 7
        Me.btnMinusOne.Text = "- One"
        Me.btnMinusOne.UseVisualStyleBackColor = True
        '
        'Button5
        '
        Me.Button5.Location = New System.Drawing.Point(186, 13)
        Me.Button5.Name = "Button5"
        Me.Button5.Size = New System.Drawing.Size(50, 35)
        Me.Button5.TabIndex = 8
        Me.Button5.Text = "- Two"
        Me.Button5.UseVisualStyleBackColor = True
        '
        'Button6
        '
        Me.Button6.Location = New System.Drawing.Point(305, 12)
        Me.Button6.Name = "Button6"
        Me.Button6.Size = New System.Drawing.Size(50, 35)
        Me.Button6.TabIndex = 9
        Me.Button6.Text = "- Three"
        Me.Button6.UseVisualStyleBackColor = True
        '
        'Form1
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.BackgroundImage = Global.laguan_project_8_counters.My.Resources.Resources._69923_draven_league_of_legends
        Me.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch
        Me.ClientSize = New System.Drawing.Size(405, 225)
        Me.Controls.Add(Me.Button6)
        Me.Controls.Add(Me.Button5)
        Me.Controls.Add(Me.btnMinusOne)
        Me.Controls.Add(Me.btnExit)
        Me.Controls.Add(Me.lblThree)
        Me.Controls.Add(Me.lblTwo)
        Me.Controls.Add(Me.lblOne)
        Me.Controls.Add(Me.btnAddThree)
        Me.Controls.Add(Me.btnAddTwo)
        Me.Controls.Add(Me.btnAddOne)
        Me.Name = "Form1"
        Me.Text = "Counters"
        Me.ResumeLayout(False)

    End Sub
    Friend WithEvents btnAddOne As System.Windows.Forms.Button
    Friend WithEvents btnAddTwo As System.Windows.Forms.Button
    Friend WithEvents btnAddThree As System.Windows.Forms.Button
    Friend WithEvents lblOne As System.Windows.Forms.Label
    Friend WithEvents lblTwo As System.Windows.Forms.Label
    Friend WithEvents lblThree As System.Windows.Forms.Label
    Friend WithEvents btnExit As System.Windows.Forms.Button
    Friend WithEvents btnMinusOne As System.Windows.Forms.Button
    Friend WithEvents Button5 As System.Windows.Forms.Button
    Friend WithEvents Button6 As System.Windows.Forms.Button

End Class
